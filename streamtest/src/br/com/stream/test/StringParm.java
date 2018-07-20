package br.com.stream.test;
	/**
	 * Implementa��o da interface <code>Stream</code> 
	 * para objetos <code>String</code>.
	 * 
	 * @author almeida.fernando
	 */
	public class StringParm implements StreamDeclare {

	    /**
	     * Stream.
	     */
	    private String stream;
	    
	    /**
	     * �ndice atual do cursor de leitura.
	     */
	    private int indexOf = 0;
	    
	    /**
	     * Construtor com o <code>String</code>.
	     * 
	     * @param stream Stream.
	     */
	    public StringParm(String stream) {
		this.stream = stream;
	    }
	    
	    /**
	     * Retorna pr�ximo caracter do stream.
	     */
	    public char getNext() {
		return this.stream.charAt(indexOf++);
	    }
	    
	    /**
	     * Retorna caracter anterior do stream.
	     */
	    public char getPrevious() {
		return getPrevious(1); 
	    }
	    
	    /**
	     * Retorna caracteres anteriores a esquerda
	     * @param shift
	     * @return
	     */
	    public char getPrevious(Integer shift) {
		return this.stream.charAt(indexOf -1 - shift);//return one character(atual) plus shift value 
	    }

	    /**
	     * Possui mais caracteres a serem lidos.
	     */
	    public boolean hasNext() {
		return (this.stream.length() > indexOf);
	    }


}
