/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import javax.swing.JMenuItem;

/**
 *
 * @author aluno
 */
public interface IUIController {
    public boolean initialize();

    public JMenuItem addMenuItem(String menuName, String menuItemName);
}
