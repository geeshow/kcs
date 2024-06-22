package kyutae.codetest.kcs.component.loader;

import java.nio.charset.Charset;
import java.util.List;
import java.util.Map;

public interface FileLoader {
    List<Map<String, String>> loadFile(String filePath) throws Exception;
    List<Map<String, String>> loadFile(String filePath, Charset charset) throws Exception;
}