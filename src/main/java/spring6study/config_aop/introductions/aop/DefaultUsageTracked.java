package spring6study.config_aop.introductions.aop;

public class DefaultUsageTracked implements UsageTracked {

    private int useCount = 0;

    @Override
    public void incrementUseCount() {
        useCount++;
        System.out.println("[UsageTracked] useCount 증가: " + useCount);
    }

    @Override
    public int getUseCount() {
        return useCount;
    }
}