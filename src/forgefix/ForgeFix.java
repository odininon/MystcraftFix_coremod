package forgefix;

import cpw.mods.fml.relauncher.IFMLLoadingPlugin;

import java.util.Map;

/**
 * @author Freyja
 *         Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */

@IFMLLoadingPlugin.TransformerExclusions("forgefix.")
public class ForgeFix implements IFMLLoadingPlugin {

    public ForgeFix() {}

    @Override
    public String[] getLibraryRequestClass()
    {
        return null;
    }

    @Override
    public String[] getASMTransformerClass()
    {
        return new String[]{"forgefix.ForgeFixTransformer"};
    }

    @Override
    public String getModContainerClass()
    {
        return "forgefix.ForgeFixModContainer";
    }

    @Override
    public String getSetupClass()
    {
        return null;
    }

    @Override
    public void injectData(Map<String, Object> data)
    {
    }
}
