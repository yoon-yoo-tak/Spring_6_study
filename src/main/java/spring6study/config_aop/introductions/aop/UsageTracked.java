package spring6study.config_aop.introductions.aop;

public interface UsageTracked {
    void incrementUseCount();
    int getUseCount();
}