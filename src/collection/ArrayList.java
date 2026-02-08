package collection;

public class ArrayList <E> {
    private int size = 0;
    private int capacity=10;
    private Object[] array=new Object[capacity];
    public void add(E element, int index){
        if(index<0||index>size)
            throw new IndexOutOfBoundsException("插入非法");
        if(size>=capacity){
                int newCapacity=capacity*(capacity>>1);
                Object[] newArray=new Object[newCapacity];
                System.arraycopy(array,0,newArray,0,size);
                array=newArray;
                capacity=newCapacity;
            }
        for(int i=size;i>index;i--)
            array[i]=array[i-1];
        array[index]=element;
            size++;
        }
        @SuppressWarnings("unckecked")
        public E remove(int index) {
            if (index < 0 || index > size - 1)
                throw new IndexOutOfBoundsException("删除非法");
            E e=(E) array[index];
            for (int i = index; i < size; i++)
                array[i] = array[i + 1];
            size--;
            return e;
        }
        public boolean isEmpty() {
            return size == 0;
        }
    @SuppressWarnings("unckecked")
        public E get(int index) {
        if(index<0 || index>size-1)
            throw new IndexOutOfBoundsException("查询位置非法");
        return (E)array[index];
        }
        public String toString(){
            StringBuilder builder=new StringBuilder();
            for(int i=0;i<size;i++) builder.append(array[i]).append(",");
            return builder.toString();
        }
}
