package com.wangwenjun.concurrent.chapter18;

/***************************************
 * @author:Alex Wang
 * @Date:2017/3/26 QQ:532500648
 * QQ交流群:286081824
 ***************************************/

/**
 * {@link ActiveObject#makeString(int, char)}
 */
public class MakeStringRequest extends MethodRequest {

    private final int count;
    private final char fillChar;

    public MakeStringRequest(Servant servant, FutureResult futureResult, int count, char fillChar) {
        super(servant, futureResult);
        this.fillChar = fillChar;
        this.count = count;
    }

    @Override
    public void execute() {
        Result result = servant.makeString(count, fillChar);
        futureResult.setResult(result);
    }
}
