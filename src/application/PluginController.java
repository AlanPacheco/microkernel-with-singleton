
package application;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

//import interfaces.ICore;
import interfaces.IDocumentFactory;
import interfaces.IPlugin;
import interfaces.IPluginController;
 

public class PluginController implements IPluginController {

	@Override
	public boolean initialize() {
		File currentDir = new File("./plugins");
		String[] plugins = currentDir.list();
		int i;
		URL[] jars = new URL[plugins.length];
		System.out.println("Encontrado " + plugins.length + " plugins instalados!");
		for (i = 0; i < plugins.length; i++)
			try {
				jars[i] = (new File("./plugins/" + plugins[i])).toURL();
			} catch (MalformedURLException ex) {
				Logger.getLogger(PluginController.class.getName()).log(Level.SEVERE, null, ex);
			}
		URLClassLoader ulc = new URLClassLoader(jars);
		for (i = 0; i < plugins.length; i++) {
			String pluginName = plugins[i].split("\\.")[0];
			IPlugin plugin = null;		
			try {
				plugin = (IPlugin) Class.forName(pluginName.toLowerCase() + "." + pluginName, true, ulc).newInstance();
			} catch (ClassNotFoundException | InstantiationException | IllegalAccessException ex) {
				Logger.getLogger(PluginController.class.getName()).log(Level.SEVERE, null, ex);
			}	
			if (plugin != null) {
				if (plugin.initialize())
					loadedPlugins.add(plugin);
			}
		}

		return true;
	}

	@Override
	public List<IPlugin> getLoadedPlugins() {
		return loadedPlugins;
	}

	@Override
	public <T> List<T> getLoadedPluginsByType() {
		List<T> loadedPluginsByType = new ArrayList<T>();
		for (IPlugin iPlugin : loadedPlugins) {
			if (iPlugin instanceof IDocumentFactory) {
				loadedPluginsByType.add((T) iPlugin);
			}
		}
		return loadedPluginsByType;
	}

	private List<IPlugin> loadedPlugins = new ArrayList<IPlugin>();
}
