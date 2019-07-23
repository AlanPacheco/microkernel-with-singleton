package textfactoryplugin;

import interfaces.IPlugin;
import interfaces.ICore;
import interfaces.IDocumentEditor;
import interfaces.IDocumentFactory;
import interfaces.IDocumentSerializer;
import interfaces.IDocumentValidator;

public class TextFactoryPlugin implements IPlugin, IDocumentFactory{

	@Override
	public IDocumentEditor createNewDocumentEditor() {
		return new TextEditor();
	}
	@Override
	public IDocumentValidator createNewDocumentValidator() {
		return new TextValidator();
	}
	@Override
	public IDocumentSerializer createNewDocumentSerializer() {
		return new TextSerializer();
	}
	@Override
	public String getSupportedExtensions() {	
		return "txt|csv";
	}
	@Override
	public boolean initialize() {
		System.out.println("\n---------------------------------------------");
		System.out.println("Plugin de Edição de Documentos Iniciado com Sucesso!");
		return true;
	}
}
