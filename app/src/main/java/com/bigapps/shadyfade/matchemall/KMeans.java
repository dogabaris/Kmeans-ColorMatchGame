package com.bigapps.shadyfade.matchemall;

import android.graphics.Color;

import com.google.common.collect.Lists;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/**
 * Created by shadyfade on 24.10.2015.
 */
public class KMeans {
    int boyut;
    int zorluk; //Zorluk easy = 3 6x6 30dk 10 patlat, medium 4 9x6 25 dk 15 patlat, hard 5 12x6 15 dk 20 patlat
    int merkez1,merkez2,merkez3,merkez4,merkez5;
    int Kume1sınır = 0,Kume2sınır = 0,Kume3sınır = 0,Kume4sınır = 0,Kume5sınır = 0;

    public KMeans(int zorluk , int boyut) {
        this.zorluk = zorluk;
        this.boyut = boyut;
        //this.RandomDizi = RandomDizi;

        System.out.println("Bilgi " + zorluk + " " + boyut);

        if(zorluk==1){
            Random rand = new Random();
            merkez1 = rand.nextInt(142);
            merkez2 = rand.nextInt(142);
            merkez3 = rand.nextInt(142);
            Merkezler.add(0,merkez1);
            Merkezler.add(1,merkez2);
            Merkezler.add(2, merkez3);

        }else if (zorluk==2){
            Random rand = new Random();
            merkez1 = rand.nextInt(142);
            merkez2 = rand.nextInt(142);
            merkez3 = rand.nextInt(142);
            merkez4 = rand.nextInt(142);
            Merkezler.add(0,merkez1);
            Merkezler.add(1,merkez2);
            Merkezler.add(2,merkez3);
            Merkezler.add(3,merkez4);

        }else if (zorluk==3){
            Random rand = new Random();
            merkez1 = rand.nextInt(142);
            merkez2 = rand.nextInt(142);
            merkez3 = rand.nextInt(142);
            merkez4 = rand.nextInt(142);
            merkez5 = rand.nextInt(142);
            Merkezler.add(0,merkez1);
            Merkezler.add(1,merkez2);
            Merkezler.add(2,merkez3);
            Merkezler.add(3,merkez4);
            Merkezler.add(4,merkez5);
        }
        System.out.println("Merkezler "+merkez1+" "+merkez2+" "+merkez3+" "+merkez4+" "+merkez5);


        int iterate=0,randomsayi;

        Random rand = new Random();

        for (Integer a=0; a<141;a++) {
            randomsayi = rand.nextInt(BaslangicDizi.size());
            RandomDizi.add(a, BaslangicDizi.get(randomsayi));
            BaslangicDizi.remove(randomsayi);
            iterate++;
        }

        System.out.println("Iterate " + iterate);

        Collections.sort(Merkezler);
        System.out.println("Siralanmis " + Merkezler.toString());

        int merkez=0,im=0;
        if(zorluk==1){//140 / 3 = 46.7 ortalama 47 itemli bir küme


            while(true){
                int iterator = 0;
            while(true){

                double min = 140;
                double uzaklık=0;
                for ( int i = 0 ; i<3 ; i++)
                {
                    uzaklık = Math.sqrt(Math.abs(Math.pow(Merkezler.get(i), 2) - Math.pow(iterator, 2)));
                    if(uzaklık<=min)
                    {
                        min = uzaklık;
                        merkez = i;
                    }

                }

                if(merkez==0)
                    Kume1sınır=iterator;
                else if(merkez==1)
                    Kume2sınır=iterator;
                else if(merkez==2)
                    Kume3sınır=iterator;

                if(iterator==140)
                    break;

                iterator++;

            }

            System.out.println("KumeSinirlari " + Kume1sınır +" "+ Kume2sınır + " " + Kume3sınır);

            int YeniMerkez1=Kume1sınır/2;
            int YeniMerkez2=Kume1sınır + (Kume2sınır-Kume1sınır) / 2;
            int YeniMerkez3=Kume2sınır + (Kume3sınır-Kume2sınır) / 2;

            if(Merkezler.get(0)==YeniMerkez1 && Merkezler.get(1)==YeniMerkez2 && Merkezler.get(2)==YeniMerkez3)
                break;

            Merkezler.clear();
            Merkezler.add(0, Kume1sınır/2);
            Merkezler.add(1, Kume1sınır + (Kume2sınır-Kume1sınır) / 2);
            Merkezler.add(2, Kume2sınır + (Kume3sınır-Kume2sınır) / 2);

            im++;
            }
            System.out.println("SonucMerkezler " + Merkezler.get(0) +" "+ Merkezler.get(1) + " " + Merkezler.get(2));
            System.out.println("SonucSinirlar " + Kume1sınır +" "+ Kume2sınır + " " + Kume3sınır);

        }else if(zorluk==2){//140 / 4  = 35 itemli bir küme
            //int merkez=0,Kume1sınır = 0,Kume2sınır = 0,Kume3sınır = 0,Kume4sınır = 0,im=0;

            while(true){
                int iterator = 0;
                while(true){

                    double min = 140;
                    double uzaklık=0;
                    for ( int i = 0 ; i<4 ; i++)
                    {
                        uzaklık = Math.sqrt(Math.abs(Math.pow(Merkezler.get(i), 2) - Math.pow(iterator, 2)));
                        if(uzaklık<min)
                        {
                            min = uzaklık;
                            merkez = i;
                        }

                    }

                    if(merkez==0)
                        Kume1sınır=iterator;
                    else if(merkez==1)
                        Kume2sınır=iterator;
                    else if(merkez==2)
                        Kume3sınır=iterator;
                    else if(merkez==3)
                        Kume4sınır=iterator;

                    if(iterator==140)
                        break;

                    iterator++;

                }

                System.out.println("KumeSinirlari " + Kume1sınır +" "+ Kume2sınır + " " + Kume3sınır+ " " + Kume4sınır);

                int YeniMerkez1=Kume1sınır/2;
                int YeniMerkez2=Kume1sınır + (Kume2sınır-Kume1sınır) / 2;
                int YeniMerkez3=Kume2sınır + (Kume3sınır-Kume2sınır) / 2;
                int YeniMerkez4=Kume3sınır + (Kume4sınır-Kume3sınır) / 2;

                if(Merkezler.get(0)==YeniMerkez1 && Merkezler.get(1)==YeniMerkez2 && Merkezler.get(2)==YeniMerkez3 && Merkezler.get(3)==YeniMerkez4)
                    break;

                Merkezler.clear();
                Merkezler.add(0, Kume1sınır / 2);
                Merkezler.add(1, Kume1sınır + (Kume2sınır-Kume1sınır) / 2);
                Merkezler.add(2, Kume2sınır + (Kume3sınır-Kume2sınır) / 2);
                Merkezler.add(3, Kume3sınır + (Kume4sınır-Kume3sınır) / 2);

                im++;
            }
            System.out.println("SonucMerkezler " + Merkezler.get(0) +" "+ Merkezler.get(1) + " " + Merkezler.get(2)+ " " + Merkezler.get(3));
            System.out.println("SonucSinirlar " + Kume1sınır +" "+ Kume2sınır + " " + Kume3sınır+ " " + Kume4sınır);


        }else if(zorluk==3){//140 / 4  = 28 itemli bir küme
            //int merkez=0,Kume1sınır = 0,Kume2sınır = 0,Kume3sınır = 0,Kume4sınır = 0,Kume5sınır = 0,im=0;
            while(true){
                int iterator = 0;
                while(true){

                    double min = 140;
                    double uzaklık=0;
                    for ( int i = 0 ; i<5 ; i++)
                    {
                        uzaklık = Math.sqrt(Math.abs(Math.pow(Merkezler.get(i), 2) - Math.pow(iterator, 2)));
                        if(uzaklık<min)
                        {
                            min = uzaklık;
                            merkez = i;
                        }

                    }

                    if(merkez==0)
                        Kume1sınır=iterator;
                    else if(merkez==1)
                        Kume2sınır=iterator;
                    else if(merkez==2)
                        Kume3sınır=iterator;
                    else if(merkez==3)
                        Kume4sınır=iterator;
                    else if(merkez==4)
                        Kume5sınır=iterator;

                    if(iterator==140)
                        break;

                    iterator++;

                }

                System.out.println("KumeSinirlari " + Kume1sınır +" "+ Kume2sınır + " " + Kume3sınır+ " " + Kume4sınır + " " + Kume5sınır);

                int YeniMerkez1=Kume1sınır/2;
                int YeniMerkez2=Kume1sınır + (Kume2sınır-Kume1sınır) / 2;
                int YeniMerkez3=Kume2sınır + (Kume3sınır-Kume2sınır) / 2;
                int YeniMerkez4=Kume3sınır + (Kume4sınır-Kume3sınır) / 2;
                int YeniMerkez5=Kume4sınır + (Kume5sınır-Kume4sınır) / 2;

                if(Merkezler.get(0)==YeniMerkez1 && Merkezler.get(1)==YeniMerkez2 && Merkezler.get(2)==YeniMerkez3 && Merkezler.get(3)==YeniMerkez4 && Merkezler.get(4)==YeniMerkez5)
                    break;

                Merkezler.clear();
                Merkezler.add(0, Kume1sınır / 2);
                Merkezler.add(1, Kume1sınır + (Kume2sınır-Kume1sınır) / 2);
                Merkezler.add(2, Kume2sınır + (Kume3sınır-Kume2sınır) / 2);
                Merkezler.add(3, Kume3sınır + (Kume4sınır-Kume3sınır) / 2);
                Merkezler.add(4, Kume4sınır + (Kume5sınır-Kume4sınır) / 2);

                im++;
            }
            System.out.println("SonucMerkezler " + Merkezler.get(0) +" "+ Merkezler.get(1) + " " + Merkezler.get(2)+ " " + Merkezler.get(3)+ " " + Merkezler.get(4));
            System.out.println("SonucSinirlar " + Kume1sınır +" "+ Kume2sınır + " " + Kume3sınır+ " " + Kume4sınır+ " " + Kume5sınır);

        }

        int it=0,it2=0,it3=0,it4=0;
        for (int k=0;k<140;k++){
            if(k>=0 && k<Kume1sınır){
                Kume1.add(k,RandomDizi.get(k));
            }

            if(k>=Kume1sınır && k<Kume2sınır){
                Kume2.add(it,RandomDizi.get(k));
                it++;
            }

            if(k>=Kume2sınır && k<Kume3sınır){
                Kume3.add(it2,RandomDizi.get(k));
                it2++;
            }

            if(k>=Kume3sınır && k<Kume4sınır){
                Kume4.add(it3,RandomDizi.get(k));
                it3++;
            }

            if(k>=Kume4sınır && k<Kume5sınır){
                Kume5.add(it4,RandomDizi.get(k));
                it4++;
            }

        }
        System.out.println("Kume1 "+Kume1.toString());
        System.out.println("Kume2 "+Kume2.toString());
        System.out.println("Kume3 "+Kume3.toString());
        System.out.println("Kume4 "+Kume4.toString());
        System.out.println("Kume5 "+Kume5.toString());

    }


    public List<Integer> getKume1() {
        return Kume1;
    }

    public List<Integer> getKume2() {
        return Kume2;
    }

    public List<Integer> getKume3() {
        return Kume3;
    }

    public List<Integer> getKume4() {
        return Kume4;
    }

    public List<Integer> getKume5() {
        return Kume5;
    }

    public List<Integer> getRandomDizi() {
        return RandomDizi;
    }

    public int getKume5sınır() {
        return Kume5sınır;
    }

    public int getKume1sınır() {
        return Kume1sınır;
    }

    public int getKume2sınır() {
        return Kume2sınır;
    }

    public int getKume3sınır() {
        return Kume3sınır;
    }

    public int getKume4sınır() {
        return Kume4sınır;
    }

    public List<Integer>Kume1= Lists.newArrayList();
    public List<Integer>Kume2= Lists.newArrayList();
    public List<Integer>Kume3= Lists.newArrayList();
    public List<Integer>Kume4= Lists.newArrayList();
    public List<Integer>Kume5= Lists.newArrayList();
    public List<Integer>RandomDizi = Lists.newArrayList();

    public List<Integer> Merkezler = Lists.newArrayList();

    public List<Integer> BaslangicDizi = Lists.newArrayList(
            Color.parseColor("#CD5C5C"),
            Color.parseColor("#F08080"),
            Color.parseColor("#FA8072"),
            Color.parseColor("#E9967A"),
            Color.parseColor("#FFA07A"),
            Color.parseColor("#DC143C"),
            Color.parseColor("#FF0000"),
            Color.parseColor("#B22222"),
            Color.parseColor("#8B0000"),
            Color.parseColor("#FFC0CB"),
            Color.parseColor("#FFB6C1"),
            Color.parseColor("#FF69B4"),
            Color.parseColor("#FF1493"),
            Color.parseColor("#C71585"),
            Color.parseColor("#DB7093"),
            Color.parseColor("#ADFF2F"),
            Color.parseColor("#7FFF00"),
            Color.parseColor("#7CFC00"),
            Color.parseColor("#00FF00"),
            Color.parseColor("#32CD32"),
            Color.parseColor("#98FB98"),
            Color.parseColor("#90EE90"),
            Color.parseColor("#00FA9A"),
            Color.parseColor("#00FF7F"),
            Color.parseColor("#3CB371"),
            Color.parseColor("#2E8B57"),
            Color.parseColor("#228B22"),
            Color.parseColor("#008000"),
            Color.parseColor("#006400"),
            Color.parseColor("#9ACD32"),
            Color.parseColor("#6B8E23"),
            Color.parseColor("#808000"),
            Color.parseColor("#556B2F"),
            Color.parseColor("#66CDAA"),
            Color.parseColor("#8FBC8F"),
            Color.parseColor("#20B2AA"),
            Color.parseColor("#008B8B"),
            Color.parseColor("#008080"),
            Color.parseColor("#FFA07A"),
            Color.parseColor("#FF7F50"),
            Color.parseColor("#FF6347"),
            Color.parseColor("#FF4500"),
            Color.parseColor("#FF8C00"),
            Color.parseColor("#FFA500"),
            Color.parseColor("#FFD700"),
            Color.parseColor("#FFFF00"),
            Color.parseColor("#FFFFE0"),
            Color.parseColor("#FFFACD"),
            Color.parseColor("#FAFAD2"),
            Color.parseColor("#FFEFD5"),
            Color.parseColor("#FFE4B5"),
            Color.parseColor("#FFDAB9"),
            Color.parseColor("#EEE8AA"),
            Color.parseColor("#F0E68C"),
            Color.parseColor("#BDB76B"),
            Color.parseColor("#00FFFF"),
            Color.parseColor("#00FFFF"),
            Color.parseColor("#E0FFFF"),
            Color.parseColor("#AFEEEE"),
            Color.parseColor("#7FFFD4"),
            Color.parseColor("#40E0D0"),
            Color.parseColor("#48D1CC"),
            Color.parseColor("#00CED1"),
            Color.parseColor("#5F9EA0"),
            Color.parseColor("#4682B4"),
            Color.parseColor("#B0C4DE"),
            Color.parseColor("#B0E0E6"),
            Color.parseColor("#ADD8E6"),
            Color.parseColor("#87CEEB"),
            Color.parseColor("#87CEFA"),
            Color.parseColor("#00BFFF"),
            Color.parseColor("#1E90FF"),
            Color.parseColor("#6495ED"),
            Color.parseColor("#7B68EE"),
            Color.parseColor("#4169E1"),
            Color.parseColor("#0000FF"),
            Color.parseColor("#0000CD"),
            Color.parseColor("#00008B"),
            Color.parseColor("#000080"),
            Color.parseColor("#191970"),
            Color.parseColor("#E6E6FA"),
            Color.parseColor("#D8BFD8"),
            Color.parseColor("#DDA0DD"),
            Color.parseColor("#EE82EE"),
            Color.parseColor("#DA70D6"),
            Color.parseColor("#FF00FF"),
            Color.parseColor("#FF00FF"),
            Color.parseColor("#BA55D3"),
            Color.parseColor("#9370DB"),
            Color.parseColor("#8A2BE2"),
            Color.parseColor("#9400D3"),
            Color.parseColor("#9932CC"),
            Color.parseColor("#8B008B"),
            Color.parseColor("#800080"),
            Color.parseColor("#4B0082"),
            Color.parseColor("#6A5ACD"),
            Color.parseColor("#483D8B"),
            Color.parseColor("#FFF8DC"),
            Color.parseColor("#FFEBCD"),
            Color.parseColor("#FFE4C4"),
            Color.parseColor("#FFDEAD"),
            Color.parseColor("#F5DEB3"),
            Color.parseColor("#DEB887"),
            Color.parseColor("#D2B48C"),
            Color.parseColor("#BC8F8F"),
            Color.parseColor("#F4A460"),
            Color.parseColor("#DAA520"),
            Color.parseColor("#B8860B"),
            Color.parseColor("#CD853F"),
            Color.parseColor("#D2691E"),
            Color.parseColor("#8B4513"),
            Color.parseColor("#A0522D"),
            Color.parseColor("#A52A2A"),
            Color.parseColor("#800000"),
            Color.parseColor("#FFFFFF"),
            Color.parseColor("#FFFAFA"),
            Color.parseColor("#F0FFF0"),
            Color.parseColor("#F5FFFA"),
            Color.parseColor("#F0FFFF"),
            Color.parseColor("#F0F8FF"),
            Color.parseColor("#F8F8FF"),
            Color.parseColor("#F5F5F5"),
            Color.parseColor("#FFF5EE"),
            Color.parseColor("#FFF5DC"),
            Color.parseColor("#FDF5E6"),
            Color.parseColor("#FFFAF0"),
            Color.parseColor("#FFFFF0"),
            Color.parseColor("#FAEBD7"),
            Color.parseColor("#FAF0E6"),
            Color.parseColor("#FFF0F5"),
            Color.parseColor("#FFE4E1"),
            Color.parseColor("#DCDCDC"),
            Color.parseColor("#D3D3D3"),
            Color.parseColor("#C0C0C0"),
            Color.parseColor("#A9A9A9"),
            Color.parseColor("#808080"),
            Color.parseColor("#696969"),
            Color.parseColor("#778899"),
            Color.parseColor("#708090"),
            Color.parseColor("#2F4F4F"),
            Color.parseColor("#000000"));

}
