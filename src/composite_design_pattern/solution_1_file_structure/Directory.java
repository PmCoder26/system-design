package composite_design_pattern.solution_1_file_structure;

import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
public class Directory implements FileSystemComponent {

    private String directoryName;
    private List<FileSystemComponent> children;


    public void add(FileSystemComponent fileSystemComponent) {
        children.add(fileSystemComponent);
    }

    @Override
    public void ls() {
        System.out.println("Directory name: " + directoryName);
        System.out.println("**********************************");
        for(FileSystemComponent child: children) {
            child.ls();
        }
    }
}
