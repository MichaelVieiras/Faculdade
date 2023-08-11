package unicesumar.ead.programacao;

import unicesumar.ead.business.PessoaBusiness;

		public class Looping {
			     public static void main(String args[]) {
			        int x = 0;
			       for (int i = 0; i < 10; i++) {
			    	   System.out.print(x + " ");
			            if (i == 3) break;
		            x = i;
			         }
		
			        System.out.print(x + " ");
			     }
			 }


