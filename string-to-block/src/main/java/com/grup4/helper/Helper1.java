package com.grup4.helper;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.grup4.model.entity.Block;
import com.grup4.model.repo.BlockRepo;


public class Helper1 {

    public static String blockRepoToJson(BlockRepo blockRepo) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        mapper.enable(SerializationFeature.INDENT_OUTPUT);

        return mapper.writeValueAsString(blockRepo);
    }

    public static BlockRepo processing(String input){
        //koreksi & mapping
        int[] arrInt = koreksi(input);

        //blocking
        Block[] blocks = blocking(arrInt);

        //to BlockRepo
        BlockRepo output = new BlockRepo();
        for(int i = 0; i< blocks.length; i++){
            output.addBlock(blocks[i]);;
        }

        return output;

    }

    public static int[] koreksi(String input){
        String inputUp = input.toUpperCase();
        int output[] = new int[inputUp.length()];
        char arr[] = inputUp.toCharArray();
        for(int i=0; i<arr.length;i++){
            if(arr[i]=='A'){output[i]=1;}
            else if(arr[i]=='B'){output[i]=2;}
            else if(arr[i]=='C'){output[i]=3;}
            else if(arr[i]=='D'){output[i]=4;}
            else if(arr[i]=='E'){output[i]=5;}
            else if(arr[i]=='F'){output[i]=6;}
            else if(arr[i]=='G'){output[i]=7;}
            else if(arr[i]=='H'){output[i]=8;}
            else if(arr[i]=='I'){output[i]=9;}
            else if(arr[i]=='J'){output[i]=10;}
            else if(arr[i]=='K'){output[i]=11;}
            else if(arr[i]=='L'){output[i]=12;}
            else if(arr[i]=='M'){output[i]=13;}
            else if(arr[i]=='N'){output[i]=14;}
            else if(arr[i]=='O'){output[i]=15;}
            else if(arr[i]=='P'){output[i]=16;}
            else if(arr[i]=='Q'){output[i]=17;}
            else if(arr[i]=='R'){output[i]=18;}
            else if(arr[i]=='S'){output[i]=19;}
            else if(arr[i]=='T'){output[i]=20;}
            else if(arr[i]=='U'){output[i]=21;}
            else if(arr[i]=='V'){output[i]=22;}
            else if(arr[i]=='W'){output[i]=23;}
            else if(arr[i]=='X'){output[i]=24;}
            else if(arr[i]=='Y'){output[i]=25;}
            else if(arr[i]=='Z'){output[i]=26;}
            else if(arr[i]=='!'){output[i]=27;}
            else if(arr[i]=='@'){output[i]=28;}
            else if(arr[i]=='#'){output[i]=29;}
            else if(arr[i]=='$'){output[i]=30;}
            else if(arr[i]=='%'){output[i]=31;}
            else output[i]=0;
        }
        return output;
    }

    public static Block[] blocking(int str[]){
        int l = str.length;
        int n = (int)Math.ceil((double)l/16);
        Block arr[] = new Block[n];
        for(int i = 0; i<n; i++){
            arr[i] = new Block();
        }
        // char karakter[] = str.toCharArray();
        int index = 0; // digunakan untuk merujuk elemen pada karakter
        
        //perulangan untuk setiap anggota dari arr
        for(int i = 0; i<n; i++){
            //perulangan untuk tiap elemen
            for(int j = 0; j<16; j++){
                if(index<l){
                    arr[i].setBlockElement(j, str[index]);
                }
                //padding
                else{
                    arr[i].setBlockElement(j, 0);
                }
                index++;
            }
        }
        return arr;
    }
}
