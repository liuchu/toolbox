package priv.liuchu.toolbox.todolist.service.enums;

import lombok.Getter;

@Getter
public enum TaskPriorityEnum {

    LOW(1),

    MIDDLE(2),

    HIGH(3)

    ;

    private final int priority;

    TaskPriorityEnum(int priority) {
        this.priority = priority;
    }
}
