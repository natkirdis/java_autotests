package ru.stqa.pft.addressbook.generators;

import com.beust.jcommander.JCommander;
import com.beust.jcommander.Parameter;
import ru.stqa.pft.addressbook.models.GroupData;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

public class GroupDataGenerator {

  @Parameter(names = "-c", description = "Group count")
  public int count;

  @Parameter(names = "-f", description = "Target file")
  public String file;

  public static void main(String[] args) throws IOException {
    GroupDataGenerator generator = new GroupDataGenerator();
    JCommander.newBuilder()
            .addObject(generator)
            .build()
            .parse(args);
    generator.run();
  }

  private void run() throws IOException {
    List<GroupData> group = generateGroups(count);
    save(group, new File(file));
  }

  private static void save(List<GroupData> groups, File file) throws IOException {
    Writer writer = new FileWriter(file);
    for (GroupData group: groups) {
      writer.write(String.format("%s;%s;%s\n",
              group.getName(), group.getHeader(), group.getFooter()));
    }
    writer.close();
  }

  private static List<GroupData> generateGroups(int count) {
    List<GroupData> groups = new ArrayList<>();
    for (int i = 0; i < count; i++) {
      groups.add(new GroupData().withName(String.format("test_%s", i))
              .withHeader(String.format("test_header_%s", i))
              .withFooter(String.format("test_footer_%s", i)));
    }
    return groups;
  }
}