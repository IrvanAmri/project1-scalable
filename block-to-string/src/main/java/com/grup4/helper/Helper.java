package com.grup4.helper;

import java.util.ArrayList;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.grup4.model.entity.Block;
import com.grup4.model.repo.BlockRepo;

public class Helper {
    
    //Json to BlockRepo
    public static BlockRepo jsonToBlockRepo(String json) throws JsonMappingException, JsonProcessingException{
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(json, BlockRepo.class);
    }

    //inverse mapping
    public static String inverseMapping(BlockRepo blockRepo){
        String out = "";
        ArrayList<Block> arr = blockRepo.getBlocks();
        int n = arr.size();
        
        //untuk tiap block
        for(int i=0; i<n; i++){
            //untuk tiap karakter
            for(int j=0; j<16; j++){
                out+=mapping(arr.get(i).getBlockElement(j));
            }
        }
        return out;
    }

    private static String mapping(int chara){
        String output = "";

        if(chara==0){output+=" ";}
        else if(chara==1){output+="a";}
        else if(chara==2){output+="b";}
        else if(chara==3){output+="c";}
        else if(chara==4){output+="d";}
        else if(chara==5){output+="e";}
        else if(chara==6){output+="f";}
        else if(chara==7){output+="g";}
        else if(chara==8){output+="h";}
        else if(chara==9){output+="i";}
        else if(chara==10){output+="j";}
        else if(chara==11){output+="k";}
        else if(chara==12){output+="l";}
        else if(chara==13){output+="m";}
        else if(chara==14){output+="n";}
        else if(chara==15){output+="o";}
        else if(chara==16){output+="p";}
        else if(chara==17){output+="q";}
        else if(chara==18){output+="r";}
        else if(chara==19){output+="s";}
        else if(chara==20){output+="t";}
        else if(chara==21){output+="u";}
        else if(chara==22){output+="v";}
        else if(chara==23){output+="w";}
        else if(chara==24){output+="x";}
        else if(chara==25){output+="y";}
        else if(chara==26){output+="z";}
        else if(chara==27){output+="!";}
        else if(chara==28){output+="@";}
        else if(chara==29){output+="#";}
        else if(chara==30){output+="$";}
        else if(chara==31){output+="%";}

        return output;
    }
}
