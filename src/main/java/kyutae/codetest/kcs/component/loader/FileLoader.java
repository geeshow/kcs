package kyutae.codetest.kcs.component.loader;

import kyutae.codetest.kcs.component.loader.dto.LoaderInterface;

import java.io.InputStream;
import java.nio.charset.Charset;
import java.util.List;

public interface FileLoader {
    <T extends LoaderInterface> List<T> loadFile(InputStream inputStream, Class<T> clazz) throws Exception;
    <T extends LoaderInterface> List<T> loadFile(InputStream inputStream, Charset charset, Class<T> clazz) throws Exception;
}