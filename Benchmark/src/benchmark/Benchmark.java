//Benchmark p/ Sistemas de Arquivos  @ Naigon Medeiros & Paulo Henrique

package benchmark;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Random;

public class Benchmark{
    
    public static void main(String[] args) throws FileNotFoundException, IOException {
        Random gerador = new Random();
        int i,j,k,l;
        long giga1 = 1073741824L;//1GB

   /*OBS: RECEBER PARAMETRO TAMANHO {1,2,3,4,5} E MULTIPLICAR PELO LONG QUE 
   REPRESENTA 1GB, O RESULTADO É O PARAMETRO DE arquivo.setLength()*/
    try{
      
//------------------------------------ESCRITA SEQUENCIAL--------------------------------------------//  
      RandomAccessFile arquivo =  new RandomAccessFile("C:\\benchmark.txt", "rw");
      //char um_byte = 'X';
      
      arquivo.setLength(10000);
      arquivo.seek(0);//inicio no começo do arquivo
      for(i=0;i<arquivo.length();i++){//escrita sequencial
      arquivo.writeByte(6);}
      //OBS: PARA A PROXIMA FORMA DE ESRITA TEM QUE DAR UM arquivo.setLength(0) pra zerar o espaço usado
 //-----------------------------------ESCRITA ALEATÓRIA--------------------------------------------//
      
      arquivo.setLength(10000);

      for(j=0;j<arquivo.length();j++){
        long numero1 = (long)(gerador.nextDouble()*arquivo.length());
        arquivo.seek(numero1);
        arquivo.writeByte(6);
      }
//-----------------------------------LEITURA SEQUENCIAL-------------------------------------------//

      System.out.print("Leitura SEQUENCIAL do Arquivo\n");
      arquivo.seek(0);
      
      for(k=0;k<arquivo.length();k++){
          System.out.print(arquivo.readByte());
      }
      System.out.println("\n");
      
//----------------------------------LEITURA ALEATORIA--------------------------------------------//     
      System.out.print("Leitura ALEATORIA do Arquivo\n");
      
      for(l=0;l<arquivo.length();l++){
        long numero2 = (long)(gerador.nextDouble()*arquivo.length());
        arquivo.seek(numero2);
        System.out.print(arquivo.readByte());
      }
      
      System.out.println("\n");
      arquivo.setLength(0);
      arquivo.close();
       
 //------------------------------------------------------------------------------------------------//   
        }
    catch(FileNotFoundException fnfe){
      System.out.println(fnfe.getMessage());
    }
    catch(IOException ioe){
      System.out.println(ioe.getMessage());
    }

  }

}
