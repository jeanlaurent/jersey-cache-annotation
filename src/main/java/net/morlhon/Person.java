package net.morlhon;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Person
{
    private int id;

    private String name;

    private int age;

    public Person()
    {
    }

    public Person(int id)
    {
        this.id = id;
        this.name = new String("Marin");
        this.age = 3;
    }

    public int getId()
    {
        return id;
    }

    public String getName()
    {
        return name;
    }

    public int getAge()
    {
        return age;
    }

}
