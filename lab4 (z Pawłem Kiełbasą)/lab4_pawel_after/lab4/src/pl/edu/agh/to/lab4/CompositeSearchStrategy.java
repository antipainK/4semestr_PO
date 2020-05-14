package pl.edu.agh.to.lab4;

import java.util.List;

public class CompositeSearchStrategy implements SearchStrategy {
    private  final List<SearchStrategy> filters;

    public CompositeSearchStrategy(List<SearchStrategy> filters){
        this.filters=filters;
    }

    @Override
    public boolean filter(Suspect suspect) {
        return filters.stream().allMatch(s-> s.filter(suspect));
    }
}
