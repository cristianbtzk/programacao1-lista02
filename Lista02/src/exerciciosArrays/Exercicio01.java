package exerciciosArrays;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;


public class Exercicio01 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		String continuar = "";
		do {
			System.out.print("Informe a quantidade de números gerados: ");
			int qtd = 0;
			do {
				qtd = scan.nextInt();
				if(qtd < 1)
					System.out.println("Erro. O valor informado deve superior a 0, informe novamente.");
			}while(qtd < 1);
			
			int soma = 0;
			
			int array[] = new int[qtd];
			
			Random generator = new Random();
			
			for (int i = 0; i < qtd; i++) {
				array[i] = generator.nextInt(5001);
				
				soma += array[i];
			}
			
			// Ordenando o array
			
			for (int i = 0; i < qtd - 1; i++) {
				int menorValor = array[i];
				int menorPos = i;
				for (int j = i + 1; j < qtd; j++) {
					if(array[j] < menorValor ) {
						menorValor = array[j];
						menorPos = j;
					}
				}
				
				array[menorPos] = array[i];
				array[i] = menorValor;
			}
			
			
			// Cálculo da moda
			int maiorRepeticao = 0;
			
			int repeticao = 0;
			
			List<Integer> modas = new ArrayList<Integer>();
			
			for (int i = 0; i < qtd; i++) {
				if(i!=0) {
					if(array[i] == array[i-1]) {
						repeticao++;
					}else {
						repeticao = 1;
					}
				}else {
					repeticao = 1;
				}
				
				if(repeticao > maiorRepeticao) {
					maiorRepeticao = repeticao;
					modas.clear();
					modas.add(array[i]);
				}else if(repeticao == maiorRepeticao) {
					modas.add(array[i]);
				}
				
				
			}
			
			// Exibição dos dados solicitados
			
			System.out.println("\nVetor gerado: ");
			
			for (int i = 0; i < qtd; i++) {
				System.out.print(array[i]+" ");
			}
		
			System.out.println("\n\nMaior valor gerado: "+array[qtd-1]);
			System.out.println("Menor valor gerado: "+array[0]);
			System.out.println("Soma: "+soma);
			double media = (double) soma/qtd;
			System.out.println("Média: "+media);
			
			// Exibindo números pares sem os repetir.
			
			System.out.print("Números pares: ");
			for (int i = 0; i < qtd; i++) {
				if(!(i!=0 && array[i] == array[i-1])) {
					if(array[i] % 2 == 0)
						System.out.print(array[i]+" ");
				}
			}
			
			// Exibindo números ímpares sem os repetir.
			
			System.out.print("\nNúmeros ímpares: ");
			for (int i = 0; i < qtd; i++) {
				if(!(i!=0 && array[i] == array[i-1])) {
					if(array[i] % 2 == 1)
						System.out.print(array[i]+" ");
				}
			}
			
			// Exibindo modas
			System.out.print("\nModa(s): ");
			for(Integer i: modas) {
				System.out.print(i+" ");
			}
			
			// Números Primos sem repetir
			
			System.out.print("\nNúmeros primos: ");
			for (int i = 0; i < qtd; i++) {
				if(!(i!=0 && array[i] == array[i-1])) {
					boolean primo = true;
					if(array[i] >= 2) {
						for (int j = 2; j < array[i] ; j++) {
							if(array[i] % j == 0) {
								primo = false;
								break;
							}
						}
					}else {
						primo = false;
					}
					
					if(primo)
						System.out.print(array[i]+" ");
				}
			}
			
			// Mediana
			float mediana = 0;
			if(qtd % 2 == 1) {
				mediana = array[(qtd/2)];
			}else {
				mediana = (float) (array[qtd/2] + array[(qtd/2) - 1]) / 2;
			}
			
			System.out.println("\nA mediana dos números gerados é "+ mediana);
			
			
			// Variância
			
			double variancia = 0;
			
			for (int i = 0; i < qtd; i++) {
				variancia += (array[i] - media) * (array[i] - media);
			}
		
			variancia /= qtd - 1;
			
			System.out.println("A variância dos valores é: "+variancia);
			
			// Desvio padrão
			
			double desvio = Math.sqrt(variancia);
			
			System.out.println("O desvio padrão dos números é "+desvio);
			scan.nextLine();
			System.out.println("\n\nDeseja continuar? Digite sim para continuar ou outra tecla para não.");
			continuar = scan.nextLine();
			
			
		}while(continuar.equalsIgnoreCase("sim"));
		
		scan.close();
	}
}
