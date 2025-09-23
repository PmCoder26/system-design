package composite_design_pattern.solution_1_file_structure;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class File implements FileSystemComponent {

    private String fileName;

    @Override
    public void ls() {
        System.out.println("File name: " + fileName);
    }

}
