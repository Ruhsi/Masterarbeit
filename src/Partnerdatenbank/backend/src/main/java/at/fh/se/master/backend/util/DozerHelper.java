package at.fh.se.master.backend.util;

import org.dozer.Mapper;

import java.util.ArrayList;
import java.util.List;

public class DozerHelper {
    public static <T, U> ArrayList<U> map(final Mapper mapper, final List<T> source, Class<U> destinationClass){
        ArrayList<U> dest = new ArrayList<>();

        for(T elem : source){
            if(elem == null) continue;
            dest.add(mapper.map(elem, destinationClass));
        }

        return dest;
    }
}
