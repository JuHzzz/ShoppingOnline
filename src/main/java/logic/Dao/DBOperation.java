package logic.Dao;

/**
 * @author JuHzzz
 * @version 1.0.0
 * Date: 2018/05/21
 */
public interface DBOperation {

    void createNewElement(Object object);    //新增元素
    Object retrieveElement(Object object);     //查找元素
    void updateElement(Object object);       //更新元素
    void deleteElement(Object object);       //删除元素
}
