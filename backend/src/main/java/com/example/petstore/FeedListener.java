package com.example.petstore;

//Listener 상속
public class FeedListener implements Listener {

    int Criteria = 0;
    public FeedListener(int criteria) {
        this.Criteria = criteria;
    }
    //freshness와 feedCriteria 비교해 조건 만족 시, 출력
    @Override
    public void freshnessChanged(int freshness) {
        if(freshness < Criteria){
            System.out.println("need freshness");
        }
    }
    
    
}
