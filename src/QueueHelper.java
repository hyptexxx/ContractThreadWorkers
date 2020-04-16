import java.util.LinkedList;
import java.util.Queue;

class QueueHelper {
    private Queue<Document> queue;
    private Queue<Document> errorDocuments;

    QueueHelper() {
        queue = new LinkedList<>();
        errorDocuments = new LinkedList<>();
    }


    int getSize() {
        return queue.size();
    }

    boolean isOverflowInQueue() {
        return queue.size() > 4;
    }

    void addToQueue(Document document) {
        queue.add(document);
    }

    boolean isEmpty() {
        return queue.isEmpty();
    }

    void addToError(Document document) { this.errorDocuments.add(document); }

    Queue<Document> getErrorDocuments() {  return errorDocuments; }

    Queue<Document> getQueue() {
        return queue;
    }

    boolean isErrorsExists() {
        return this.errorDocuments.size() > 0;
    }

    void clearQueue() {
        this.queue.clear();
    }

    void clearQueueError() {
        this.errorDocuments.clear();
    }
}
