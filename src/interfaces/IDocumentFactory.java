/*
 * To change this license header, choose License Headers in Project Properties. * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

/**
 *
 * @author aluno
 */
public interface IDocumentFactory {
    // Metodos para criacao dos tres produtos
	public IDocumentEditor createNewDocumentEditor();
	public IDocumentValidator createNewDocumentValidator();
	public IDocumentSerializer createNewDocumentSerializer();   
    public String getSupportedExtensions(); // return "gif|png|jpg";
}