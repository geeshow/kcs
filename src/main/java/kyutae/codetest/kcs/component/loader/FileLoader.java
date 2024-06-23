package kyutae.codetest.kcs.component.loader;

import kyutae.codetest.kcs.component.loader.dto.LoaderInterface;

import java.nio.charset.Charset;
import java.util.List;

public interface FileLoader {
    <T extends LoaderInterface> List<T> loadFile(String filePath, Class<T> clazz) throws Exception;
    <T extends LoaderInterface> List<T> loadFile(String filePath, Charset charset, Class<T> clazz) throws Exception;
}