package cc.moreluck.myxxxjob.third.alist.response;

import lombok.Data;

import java.util.List;

/**
 * @author huangqi
 * @date 2024/11/12 11:17
 * @description:
 */
@Data
public class FsSearchResponse {

    private List<FileItem> content;
    /**
     * 总数
     */
    private String total;

    /**
     * FileItem 类用于表示文件或目录的基本信息。
     */
    @Data
    public static class FileItem {

        /**
         * 父目录的路径。
         */
        private String parent;

        /**
         * 文件或目录的名称。
         */
        private String name;

        /**
         * 是否为目录的标志。
         * true - 是目录
         * false - 不是目录
         */
        private boolean isDir;

        /**
         * 文件或目录的大小（字节）。
         */
        private long size;

        /**
         * 文件类型标识（0 表示文件，1 表示目录等）。
         */
        private int type;

    }
}
