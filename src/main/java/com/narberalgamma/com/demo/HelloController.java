package com.narberalgamma.com.demo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.web.bind.annotation.RequestMapping;
import org .springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
public class HelloController {
    String[] names = {"tuyano",
    "hanako", "taro",
    "sachiko", "ichiro"};
    String[] mails = {"syoda@tuuyano.com",
    "hanako@flower", "taro@yamada",
    "sachiko@happy", "ichiro@baseball"};

    @RequestMapping("/{id}")
    public DataObject index(@PathVariable int id) {
        return new DataObject(id, names[id], mails[id]);
    }

}


@Getter
@Setter
@AllArgsConstructor
class DataObject {
    private int id;
    private String name;
    private String value;
}
