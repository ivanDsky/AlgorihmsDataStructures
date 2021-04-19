package labs.lab2.data;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

public class Database {
    private final ArrayList<Group> groups = new ArrayList<>();
    private static Database instance = null;

    public static Database getInstance(){
        if(instance == null)instance = new Database();
        return instance;
    }

    public void addGroup(Group group){
        groups.add(group);
    }

    public void updateGroup(String name,Group group){
        Group org = getGroupByName(name);
        org.setName(group.getName());
        org.setDescription(group.getDescription());
    }

    public Group getGroupByName(String name){
        Group org = null;
        for(Group gr : groups){
            if(gr.getName().equals(name)){
                org = gr;
                break;
            }
        }
        return org;
    }

    public void removeGroup(Group group){
        group.removeAllProducts();
        groups.remove(group);
    }

    public ArrayList<Group> getGroups(){
        return groups;
    }

    public boolean isNameUnique(String name, DBItem type){
        if(name == null)return true;
        if(type == DBItem.GROUP){
            for(Group gr : groups){
                if(name.equalsIgnoreCase(gr.getName()))return false;
            }
            return true;
        }
        if(type == DBItem.PRODUCT){
            for(Group gr: groups){
                if(!gr.isProductUnique(name))return false;
            }
            return true;
        }
        return false;
    }

    public Database databaseMatchPattern(String pattern){
        Database ret = new Database();
        for(Group gr : groups){
            Group nw = gr.groupMatchPattern(pattern);
            if(nw != null)ret.addGroup(nw);
        }
        return ret;
    }

    public void saveToFile(String pathToFileFolder){
        File folder = new File(pathToFileFolder);
        if(!folder.exists()){
            folder.mkdirs();
        }else{
            File[] contents = folder.listFiles();
            if(contents != null){
                for(File f : contents)f.delete();
            }
            if(!folder.exists())folder.mkdirs();
        }
        File file = new File(pathToFileFolder + "/Groups.txt");
        file.getParentFile().mkdirs();
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(file, StandardCharsets.UTF_8));
            writer.write(getAllGroupNames());
            writer.close();
            for(Group gr : groups){
                file = new File(pathToFileFolder + '/' + gr.getName() + ".txt");
                writer = new BufferedWriter(new FileWriter(file,StandardCharsets.UTF_8));
                writer.write(gr.getAllProducts());
                writer.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public double getSumPrice(){
        double sum = 0;
        for(Group gr : groups){
            sum += gr.getSumPrice();
        }
        return sum;
    }

    public String getAllGroupNames(){
        StringBuilder builder = new StringBuilder("Groups:\n");
        for(Group gr : groups){
            builder.append('\t').append(gr.getName()).append('\n');
        }
        builder.deleteCharAt(builder.length() - 1);
        return builder.toString();
    }


    @Override
    public String toString() {
        StringBuilder ret = new StringBuilder();
        for(Group gr : groups){
            ret.append(gr.toString()).append('\n');
        }
        return ret.toString();
    }
}
