package homework.hw10;

import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import java.awt.*;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class TreeFrame extends JFrame {
    TreeFrame(){
        JPanel panel = new JPanel(new GridLayout(1,1,0,0));
        JScrollPane scrollPane = new JScrollPane(panel);
        File file = new File("C:\\");
        JTree tree = new JTree();

        DefaultMutableTreeNode root = new DefaultMutableTreeNode(file.getName());
        DefaultTreeModel model = new DefaultTreeModel(root);

        createModel(file,root);

        tree.setModel(model);

        panel.add(tree);
        add(scrollPane);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(600,400);
        setVisible(true);
    }

    private void createModel(File file,DefaultMutableTreeNode root){
        File[] files = file.listFiles();
        if(files == null){
            return;
        }
        ArrayList<DefaultMutableTreeNode> list = new ArrayList<>();
        for(File cur : files){
            DefaultMutableTreeNode node = new DefaultMutableTreeNode(cur.getName());
            if(cur.isDirectory())root.add(node);
            else list.add(node);
            createModel(cur,node);
        }
        for(DefaultMutableTreeNode node : list){
            root.add(node);
        }
    }

    public static void main(String[] args) {
        new TreeFrame();
    }
}
