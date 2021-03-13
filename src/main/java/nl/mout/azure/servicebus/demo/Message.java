package nl.mout.azure.servicebus.demo;

import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
class Message {

    @NonNull
    private final String content;
}
