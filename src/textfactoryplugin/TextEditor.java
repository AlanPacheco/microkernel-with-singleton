package textfactoryplugin;

import interfaces.IDocumentEditor;;

public class TextEditor implements IDocumentEditor{
	
	@Override
	public void open() {
		System.out.println("TextEditor - Metodo Open: Arquivo aberto com sucesso");
	}
}
