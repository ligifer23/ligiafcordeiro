package br.com.stream.test;

import java.util.Arrays;

public class StreamCheck {
	static char[] vogais = {'a','e','i','o','u'};
	static char[] consoantes = {'b','c','d','f','g','h','j','k',
			'l','m','n','p','q','r','s','t','v','x','w','y','z'};

/* Conforme solicitado no enunciado do exercício 
 * Dada uma stream, encontre o primeiro caractere vogal, após uma consoante, onde a mesma é
 antecessora a uma vogal e que não se repita no resto da stream */ 

	public static char firstFound(StreamDeclare input) throws CharException {
		char c;
		int size = 5;
		int indexFound, matchIndex = 0;
		char previousCharacter = '1';
		// Array de caracters encontrados 
		char[] matchChars = new char[size];
		// Array de controle de quantidade dos caracteres repetidos
		short[] quantidadeMatchedRepetidos = new short[size];
				
/* Método hasNext()*/		 		
		while (input.hasNext()) {
			c = input.getNext();			
			if (isVogal(c)) {
				if (isConsonant(previousCharacter)) {
					if (isVogal(input.getPrevious(2))) {
				
						indexFound = indexOf(c, matchChars);

						if(indexFound >= 0){
							quantidadeMatchedRepetidos[indexFound]++;
						}else{
							matchChars[matchIndex] = c;
							quantidadeMatchedRepetidos[matchIndex]++;
							matchIndex++;
						}
					}
				}
			}

			if (matchIndex == matchChars.length) {
				matchChars = Arrays.copyOf(matchChars, matchChars.length + size);
				quantidadeMatchedRepetidos = Arrays.copyOf(quantidadeMatchedRepetidos, matchChars.length + size);
			}
			previousCharacter = c;
		}
		return indexOfFirstNotRepeated(quantidadeMatchedRepetidos, matchChars);
	}

	private static char indexOfFirstNotRepeated(short[] quantidadeCharsRepetidos, char[] matchChars) throws CharException {
		for (int i = 0; i < quantidadeCharsRepetidos.length; i++) {
			if (quantidadeCharsRepetidos[i] == 1) {
				return matchChars[i];
			}
		}
		throw new CharException();
	}

	
	// Varredura do array

		private static int indexOf(char c, char[] chars) {
		for (int i = 0; i < chars.length; i++) {
			if (c == chars[i]) {
				return i;
			}
		}
		return -1;
	}

	// Verifica se o caractere atual é uma vogal
	
		private static boolean isVogal(char c) {
		for (int i = 0; i < vogais.length; i++) {
			if (Character.toUpperCase(c) == Character.toUpperCase(vogais[i])) {
				return true;
			}
		}
		return false;
	}

  private static boolean isConsonant(char previousCharacter) {
		for (int i = 0; i < consoantes.length; i++) {
			if (Character.toUpperCase(previousCharacter) == Character.toUpperCase(consoantes[i])) {
				return true;
			}
		}
		return false;
	}

	public static void main(String[] args) {
		StringParm s = new StringParm("eAbBOBecegarcavegau");
		try {
			char foundChar = StreamCheck.firstFound(s);
			System.out.println("Caracter vogal encontrado = " + foundChar);
		} catch (CharException e) {
			System.out.println("Caracter vogal não encontrado na string informada");
		}
	}

}
