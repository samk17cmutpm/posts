package com.post.design_pattern.dependency_inversion_principle

/**
 * Created by sam_nguyen on 1/16/18.
 */
class Manager constructor(val worker: Worker) {
    fun work() {
        worker.work()
    }
}