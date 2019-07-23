package textfactoryplugin;

import interfaces.IDocumentValidator;

public class TextValidator implements IDocumentValidator{

	@Override
	public void validate() {
		System.out.println("TextValidate - Metodo validate() : Arquivo validado com sucesso");
	}
}
