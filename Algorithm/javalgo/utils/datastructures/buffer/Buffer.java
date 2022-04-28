package datastructures.buffer;

import java.util.concurrent.atomic.AtomicInteger;

public class Buffer {
    
    private char[] _buffer;
    public final int _buffer_size;
    private int _write_index = 0;
    private int _read_index = 0;
    private AtomicInteger _readable_data = new AtomicInteger(0);

    public Buffer(int buffer_size){
        if(!IsPowerOfTwo(buffer_size)) throw new IllegalArgumentException();
        this._buffer_size = buffer_size;
        _buffer = new char[buffer_size];
    }

    private boolean IsPowerOfTwo(int i) {
        return (i & (i - 1)) == 0;
    }

    private int getTrueIndex(int i){
        return i % _buffer_size;
    }

    public Character readOutChar() {
        Character result = null;

        // if we have data to read
        if (_readable_data.get() > 0) {

            result = Character.valueOf(_buffer[getTrueIndex(_read_index)]);
            _readable_data.decrementAndGet();
            _read_index++;
        }

        return result;
    }

    public boolean writeToCharBuffer(char c) {
        boolean result = false;

        // if we can write to the buffer
        if (_readable_data.get() < _buffer_size) {
            // write to buffer
            _buffer[getTrueIndex(_write_index)] = c;
            _readable_data.incrementAndGet();
            _write_index++;
            result = true;
        }

        return result;
    }

    private static class TestReadWorker implements Runnable {
        Buffer _buffer;

        public TestReadWorker(Buffer cb){
            this._buffer = cb;
        }

        @Override
        public void run() {
            System.out.println("Buffering:");
            while(!Thread.interrupted()){
                Character c = _buffer.readOutChar();
                if (c != null) {
                    System.out.println(c.charValue());
                } else {
                    Thread.yield();
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e){
                        System.out.println();
                        return;
                    }
                }
            }
        }

    }
}
