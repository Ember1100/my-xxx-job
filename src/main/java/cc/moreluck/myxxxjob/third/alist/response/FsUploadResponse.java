package cc.moreluck.myxxxjob.third.alist.response;

import lombok.Data;

/**
 * @author huangqi
 * @date 2024/11/12 11:20
 * @description:
 */
@Data
public class FsUploadResponse {

    private Task task;

    /**
     * Task 类用于表示任务的基本信息。
     */
    @Data
    public class Task {

        /**
         * 任务的唯一标识符。
         */
        private String id;

        /**
         * 任务的名称。
         */
        private String name;

        /**
         * 任务的状态，表示任务的当前状态。
         */
        private int state;

        /**
         * 任务的状态描述，通常用于表示任务的详细状态信息。
         */
        private String status;

        /**
         * 任务的进度，表示任务完成的百分比（0-100）。
         */
        private int progress;

        /**
         * 错误信息，如果任务执行失败，将包含错误描述。
         */
        private String error;

    }
}
