package spring6study.config_aop.collectionProperty;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ListProperty {
    @Value("${test.color-list}")
    private List<String> colorlist;

    public List<String> getColorlist() {
        return colorlist;
    }
}
