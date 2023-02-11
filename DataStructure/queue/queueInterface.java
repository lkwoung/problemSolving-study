/**
 * BFS 구현 시 이용
 * FIFO first in first out
 * LILO last in last out
 * @param <E>
 */
public interface queueInterface<E> {
    /**
     * 큐에 요소 삽입
     * @param item
     */
    void enqueue(E item);

    /**
     * 큐에서 요소 제거
     * 맨 앞의 요소가 제거되고 한 칸씩 앞으로 당겨짐
     * @return
     */
    E dequeue();

    /**
     * 큐의 맨 앞 요소 조회
     * @return
     */
    E peek();

    /**
     * 요소 검색
     * 큐에 해당하는 요소가 있는지 확인
     * 있으면 해당 인덱스 없으면 -1을 반환
     * @param target
     * @return
     */
    int search(E target);

    /**
     * 큐의 상태 출력
     */
    void checkState();

    /**
     * 큐가 비었는지 확인
     * 비었다면 true 아니면 false 반환
     * @return
     */
    boolean isEmpty();

    /**
     * 큐가 찼는지 확인
     * 큐에 자리가 없으면 true 아니면 false 반환
     * @return
     */
    boolean isFull();


}
