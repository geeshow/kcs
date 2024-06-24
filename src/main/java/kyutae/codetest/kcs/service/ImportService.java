package kyutae.codetest.kcs.service;

abstract class ImportService {

    void printProgress(long progressCount, long allCount) {
        int progress = (int) ((progressCount / (double) allCount) * 100);

        int dashes = progress / 2;
        int spaces = 50 - dashes;
        String progressBar = "[" + String.format("%02d", progress) + "%]" + "-".repeat(dashes) + " ".repeat(spaces) + " " + progressCount + "/" + allCount;
        System.out.print("\r" + progressBar);
    }

}
