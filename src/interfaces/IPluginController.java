/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import java.util.List;
import interfaces.IPlugin;
/**
 *
 * @author aluno
 */
public interface IPluginController {
    public boolean initialize();
    public List<IPlugin> getLoadedPlugins();
    public <T> List<T> getLoadedPluginsByType();
}