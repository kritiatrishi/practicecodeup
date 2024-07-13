package org.practice.concepts;

import com.sun.imageio.spi.OutputStreamImageOutputStreamSpi;

import java.io.*;

public class FileHandling {
    public static void main(String[] args) throws IOException {
        //create a new file
        File fo=new File("note.txt");// for deletion use fo.delete() or getName() to check if the file is deleted or not
        fo.createNewFile();
        //write in file
        try{
            FileWriter fw=new FileWriter("note.txt",true);
            fw.write("hindi sanskrit");
            fw.close();
        }catch (IOException e){
            System.out.println(e.getMessage());
        }
        try(InputStreamReader isr=new InputStreamReader(System.in)){
                System.out.print("Enter some letters:");
                int letters=isr.read();
                while(isr.ready()){
                    System.out.println((char) letters);
                    letters=isr.read();
                }
                isr.close();
            System.out.println();

        }catch (IOException e){
            System.out.print(e.getMessage());

        }
        //BufferedReader-reads text from a character inputstream, buffering chars for efficiency
        //converts bytestream to character stream and then reading char stream
        try(BufferedReader br=new BufferedReader(new InputStreamReader(System.in))){
            System.out.println("typed:"+br.readLine());
        }catch (IOException e){
            System.out.println(e.getMessage());
        }
        //file reader as br
        try(BufferedReader br=new BufferedReader(new FileReader("note.txt"))){
            while(br.ready()){
            System.out.println("typed:"+br.readLine());}
        }catch (IOException e){
            System.out.println(e.getMessage());
        }
        //
        try(FileReader fr=new FileReader("note.txt")){
          //  System.out.print("Enter some letters:");
            int letters=fr.read();
            while(fr.ready()){
                System.out.println((char) letters);
                letters=fr.read();
            }
            fr.close();
            System.out.println();

        }catch (IOException e){
            System.out.print(e.getMessage());
        }
        //output
        OutputStream os=System.out;
        //os.write(😍);// error as range is exceeded
        System.out.println();
        try(BufferedWriter osw=new BufferedWriter(new OutputStreamWriter(System.out))){
         //   osw.write(😍)
            osw.write("jafbajbg,sgjb");
        }catch (IOException e){
            System.out.println(e.getMessage());
        }
    }

}
