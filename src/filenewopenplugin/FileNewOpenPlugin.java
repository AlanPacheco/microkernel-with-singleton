
package filenewopenplugin;

import java.io.File;
import java.util.List;
import javax.swing.JFileChooser;
import javax.swing.JMenuItem;

import application.Core;
import application.UIController;
//import interfaces.ICore;
import interfaces.IDocumentFactory;
import interfaces.IPlugin;
import interfaces.IUIController;

public class FileNewOpenPlugin implements IPlugin {

	@Override
	public boolean initialize() {
		IUIController uiController = Core.getInstance().getUIController();
		
		JMenuItem fileNewItem = uiController.addMenuItem("File", "New");
		fileNewItem.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				JFileChooser fileChooserFileNewItem = new JFileChooser();
				fileChooserFileNewItem.setDialogTitle("Open File");
				int fileOpen = fileChooserFileNewItem.showOpenDialog(((UIController) uiController).getMainWindow());
				if (fileOpen == JFileChooser.APPROVE_OPTION) {
					File fileSelected = fileChooserFileNewItem.getSelectedFile();
					String[] splitFileSelected = fileSelected.getName().split("\\.");
					String extensionFileSelected = splitFileSelected[splitFileSelected.length - 1];
					System.out.println("\nTipo de arquivo selecionado: " + extensionFileSelected.toUpperCase());
					List<IDocumentFactory> listIDocumentFactory = Core.getInstance().getPluginController().getLoadedPluginsByType();
					IDocumentFactory defaultDocumentFactory = getFactoryByExtension(extensionFileSelected,
							listIDocumentFactory);
					if (defaultDocumentFactory != null) {
						System.out.println("Localizado plugin compativel com o arquivo.\n");
						
						// Criação dos objetos
						defaultDocumentFactory.createNewDocumentEditor().open();
						defaultDocumentFactory.createNewDocumentValidator().validate();
						defaultDocumentFactory.createNewDocumentSerializer().load();
						defaultDocumentFactory.createNewDocumentSerializer().save();
					} else
						System.out.println("Não há plugin compatível com o arquivo selecionado.\n");
				}
			}
		});

		JMenuItem fileOpenItem = uiController.addMenuItem("File", "Open");
		fileOpenItem.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				System.out.println("Voce clicou no File->Open");
			}
		});
		return true;
	}

	private IDocumentFactory getFactoryByExtension(String extensionFile, List<IDocumentFactory> listIDocumentFactory) {
		for (IDocumentFactory aux : listIDocumentFactory) {
			String[] arrayExtensions = aux.getSupportedExtensions().split("\\|");
			for (String extensions : arrayExtensions) 
				if (extensionFile.equalsIgnoreCase(extensions))
					return aux;
		}
		return null;
	}
}
