package application;

import interfaces.ICore;
import interfaces.IPluginController;
import interfaces.IUIController;

public class Core implements ICore {
    private Core() {
    }
    
    public static Core getInstance() {
    	if(instance == null) {
    		instance = new Core();
            uiController.initialize();
            pluginController.initialize();
    	}
    	return instance;
    }
    
    @Override
    public IUIController getUIController() {
        return uiController;
    }

    @Override
    public IPluginController getPluginController() {
        return pluginController;
    }
    
    private static Core instance = null;
    private static IUIController uiController = new UIController();
    private static IPluginController pluginController = new PluginController();
}
