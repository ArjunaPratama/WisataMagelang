package com.arjuna.wisatasemarang.Model;

import java.util.ArrayList;

public class WisataData {

    public static String[] [] dataWisata = new String[][]{
            {"Candi Borobudur", "-7.607874", "110.203751"},
            {"Gereja Ayam", "-7.605665", "110.180519"},
            {"Top Selfi Pinus", "-7.461071", "110.383952"},
            {"Taman KyaiLanggeng", "-7.484397", "110.210503"},
            {"Alun Alun Kota Magelang", "-7.476932", "110.218151"},
            {"Candi Pawon", "-7.606121", "110.219612"},
            {"Candi Mendut", "-7.604021", "110.272390"},
            {"Candi Ngawen", "-7.634319", "110.296818"},
            {"Candi Canggal", "-7.424654", "110.167576"},
            {"Candi Selogriyo", "-7.494582", "110.381294"},
            {"Ketep Pass", "-7.500337", "110.393925"},
            {"Air Terjun Kedung Kayangan", "-7.368000", "110.362419"},
            {"Puthuk Setumbu", "-7.468960", "110.218560"},
            {"Gunung Andong", "-7.493290", "110.221250"},
            {"Rumah Kamera", "-7.466420", "110.221340"},
            {"Gereja Ayam", "-7.605665", "110.180519"},

    };
    public static ArrayList<Wisata> getWisata() {
        Wisata wisata = null;
        ArrayList<Wisata> list = new ArrayList<>();
        for (int i = 0; i < dataWisata.length; i++) {
            wisata = new Wisata();
            wisata.setNama(dataWisata[i][0]);
            wisata.setLat(Double.parseDouble(dataWisata[i][1]));
            wisata.setLon(Double.parseDouble(dataWisata[i][2]));
            list.add(wisata);
        }

        return list;
    }
}
