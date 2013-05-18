package forgefix;

import com.google.common.eventbus.EventBus;
import cpw.mods.fml.common.DummyModContainer;
import cpw.mods.fml.common.LoadController;
import cpw.mods.fml.common.ModMetadata;

import java.util.Arrays;

/**
 * @author Freyja
 *         Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
public class ForgeFixModContainer extends DummyModContainer {

    public ForgeFixModContainer()
    {
        super(new ModMetadata());

        ModMetadata md = getMetadata();
        md.description = "Coremod to fix an issue with Lecterns in Mystcraft";
        md.name = "Mystcraft fix";
        md.modId = "Mystcraft_fix";
        md.version = "0.0.1";
        md.credits = "Freyja";
        md.authorList = Arrays.asList("Freyja");
        md.url = "";
    }

    @Override
    public boolean registerBus(EventBus bus, LoadController controller)
    {
        return true;
    }
}
