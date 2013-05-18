package forgefix;

import cpw.mods.fml.relauncher.IClassTransformer;
import org.objectweb.asm.ClassReader;
import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.tree.ClassNode;
import org.objectweb.asm.tree.InsnNode;
import org.objectweb.asm.tree.MethodNode;

import static org.objectweb.asm.Opcodes.*;
import static org.objectweb.asm.Type.BOOLEAN_TYPE;
import static org.objectweb.asm.Type.getMethodDescriptor;

/**
 * @author Freyja
 *         Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
public class ForgeFixTransformer implements IClassTransformer {
    @Override
    public byte[] transform(String name, String transformedName, byte[] bytes)
    {
        if (bytes == null) return bytes;

        if (transformedName.equals("com.xcompwiz.mystcraft.world.gen.structure.ComponentVillageArchivistHouse") || (transformedName.equals("com.xcompwiz.mystcraft.world.gen.structure.ComponentScatteredFeatureSmallLibrary"))) {
            ClassNode classNode = new ClassNode();
            ClassReader classReader = new ClassReader(bytes);

            classReader.accept(classNode, 0);

            MethodNode vanillaMethod = null;
            for (MethodNode method : classNode.methods) {
                if (method.name.equals("generateStructureLectern")) {
                    vanillaMethod = method;
                }
            }

            MethodNode moddedMethod = new MethodNode(ASM4, ACC_PROTECTED, "generateStructureLectern", getMethodDescriptor(BOOLEAN_TYPE), null, null);
            moddedMethod.desc = "(Lnet/minecraft/world/World;Lnet/minecraft/world/gen/structure/StructureBoundingBox;Ljava/util/Random;IIIIILnet/minecraftforge/common/ChestGenHooks;)Z";
            moddedMethod.instructions.add(new InsnNode(ICONST_0));
            moddedMethod.instructions.add(new InsnNode(IRETURN));


            if (moddedMethod != null) {
                classNode.methods.remove(vanillaMethod);
                moddedMethod.accept(classNode);

                ClassWriter writer = new ClassWriter(ClassWriter.COMPUTE_FRAMES | ClassWriter.COMPUTE_MAXS);
                classNode.accept(writer);
                return writer.toByteArray();
            }
        }

        return bytes;
    }
}
