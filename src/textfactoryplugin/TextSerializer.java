package textfactoryplugin;

import interfaces.IDocumentSerializer;

public class TextSerializer implements IDocumentSerializer{

	@Override
	public void load() {
		System.out.println("TextSerializer - Metodo load(): Arquivo carregado com sucesso");
	}
	@Override
	public void save() {
		System.out.println("TextSerializer - Metodo save() : Arquivo salvo com sucesso");
	}
}
