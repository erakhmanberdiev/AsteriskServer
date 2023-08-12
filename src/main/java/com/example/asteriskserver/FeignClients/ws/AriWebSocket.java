package com.example.asteriskserver.FeignClients.ws;

import com.example.asteriskserver.FeignClients.AsteriskARI.Response.*;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.websocket.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

/**
 * created by  :  erakhmanberdiev
 * created date & time: 08.08.2023  12:26
 */

@ClientEndpoint
@Service
public class AriWebSocket {
    @Autowired
    private MessagHandler messagHandler;
    private static Set<Session> sessions = new HashSet<>();

    @OnOpen
    public void onOpen(Session session) {
        System.out.println("WebSocket opened: " + session.getId());
        sessions.add(session);
    }

    @OnMessage
    public void onMessage(String message, Session session) {
//        System.out.println("Stock information received: " + message + " from " + session.getId());
        try {
            ObjectMapper mapper = new ObjectMapper();
            JsonNode jsonNode = mapper.readTree(message);
            switch (jsonNode.get("type").asText()) {
                case "StasisStart":
                    StasisStart stasisStart = mapper.readValue(message, StasisStart.class);
                    System.out.println(stasisStart);
                    messagHandler.onMessage(stasisStart);
                    break;
                case "DeviceStateChanged":
                    DeviceStateChanged deviceStateChanged = mapper.readValue(message, DeviceStateChanged.class);
                    System.out.println(deviceStateChanged);
                    messagHandler.onMessage(deviceStateChanged);
                    break;
                case "PlaybackStarted":
                    PlaybackStarted playbackStarted = mapper.readValue(message, PlaybackStarted.class);
                    System.out.println(playbackStarted);
                    messagHandler.onMessage(playbackStarted);
                    break;
                case "PlaybackContinuing":
                    PlaybackContinuing playbackContinuing = mapper.readValue(message, PlaybackContinuing.class);
                    System.out.println(playbackContinuing);
                    messagHandler.onMessage(playbackContinuing);
                    break;
                case "PlaybackFinished":
                    PlaybackFinished playbackFinished = mapper.readValue(message, PlaybackFinished.class);
                    System.out.println(playbackFinished);
                    messagHandler.onMessage(playbackFinished);
                    break;
                case "RecordingStarted":
                    RecordingStarted recordingStarted = mapper.readValue(message, RecordingStarted.class);
                    System.out.println(recordingStarted);
                    messagHandler.onMessage(recordingStarted);
                    break;
                case "RecordingFinished":
                    RecordingFinished recordingFinished = mapper.readValue(message, RecordingFinished.class);
                    System.out.println(recordingFinished);
                    messagHandler.onMessage(recordingFinished);
                    break;
                case "RecordingFailed":
                    RecordingFailed recordingFailed = mapper.readValue(message, RecordingFailed.class);
                    System.out.println(recordingFailed);
                    messagHandler.onMessage(recordingFailed);
                    break;
                case "ApplicationMoveFailed":
                    ApplicationMoveFailed applicationMoveFailed = mapper.readValue(message, ApplicationMoveFailed.class);
                    System.out.println(applicationMoveFailed);
                    messagHandler.onMessage(applicationMoveFailed);
                    break;
                case "ApplicationReplaced":
                    ApplicationReplaced applicationReplaced = mapper.readValue(message, ApplicationReplaced.class);
                    System.out.println(applicationReplaced);
                    messagHandler.onMessage(applicationReplaced);
                    break;
                case "BridgeCreated":
                    BridgeCreated bridgeCreated = mapper.readValue(message, BridgeCreated.class);
                    System.out.println(bridgeCreated);
                    messagHandler.onMessage(bridgeCreated);
                    break;
                case "BridgeDestroyed":
                    BridgeDestroyed bridgeDestroyed = mapper.readValue(message, BridgeDestroyed.class);
                    System.out.println(bridgeDestroyed);
                    messagHandler.onMessage(bridgeDestroyed);
                    break;
                case "BridgeMerged":
                    BridgeMerged bridgeMerged = mapper.readValue(message, BridgeMerged.class);
                    System.out.println(bridgeMerged);
                    messagHandler.onMessage(bridgeMerged);
                    break;
                case "BridgeBlindTransfer":
                    BridgeBlindTransfer bridgeBlindTransfer = mapper.readValue(message, BridgeBlindTransfer.class);
                    System.out.println(bridgeBlindTransfer);
                    messagHandler.onMessage(bridgeBlindTransfer);
                    break;
                case "BridgeAttendedTransfer":
                    BridgeAttendedTransfer bridgeAttendedTransfer = mapper.readValue(message, BridgeAttendedTransfer.class);
                    System.out.println(bridgeAttendedTransfer);
                    messagHandler.onMessage(bridgeAttendedTransfer);
                    break;
                case "BridgeVideoSourceChanged":
                    BridgeVideoSourceChanged bridgeVideoSourceChanged = mapper.readValue(message, BridgeVideoSourceChanged.class);
                    System.out.println(bridgeVideoSourceChanged);
                    messagHandler.onMessage(bridgeVideoSourceChanged);
                    break;
                case "ChannelCreated":
                    ChannelCreated channelCreated = mapper.readValue(message, ChannelCreated.class);
                    System.out.println(channelCreated);
                    messagHandler.onMessage(channelCreated);
                    break;
                case "ChannelDestroyed":
                    ChannelDestroyed channelDestroyed = mapper.readValue(message, ChannelDestroyed.class);
                    System.out.println(channelDestroyed);
                    messagHandler.onMessage(channelDestroyed);
                    break;
                case "ChannelEnteredBridge":
                    ChannelEnteredBridge channelEnteredBridge = mapper.readValue(message, ChannelEnteredBridge.class);
                    System.out.println(channelEnteredBridge);
                    messagHandler.onMessage(channelEnteredBridge);
                    break;
                case "ChannelLeftBridge":
                    ChannelLeftBridge channelLeftBridge = mapper.readValue(message, ChannelLeftBridge.class);
                    System.out.println(channelLeftBridge);
                    messagHandler.onMessage(channelLeftBridge);
                    break;
                case "ChannelStateChange":
                    ChannelStateChange channelStateChange = mapper.readValue(message, ChannelStateChange.class);
                    System.out.println(channelStateChange);
                    messagHandler.onMessage(channelStateChange);
                    break;
                case "ChannelDtmfReceived":
                    ChannelDtmfReceived channelDtmfReceived = mapper.readValue(message, ChannelDtmfReceived.class);
                    System.out.println(channelDtmfReceived);
                    messagHandler.onMessage(channelDtmfReceived);
                    break;
                case "ChannelDialplan":
                    ChannelDialplan channelDialplan = mapper.readValue(message, ChannelDialplan.class);
                    System.out.println(channelDialplan);
                    messagHandler.onMessage(channelDialplan);
                    break;
                case "ChannelCallerId":
                    ChannelCallerId channelCallerId = mapper.readValue(message, ChannelCallerId.class);
                    System.out.println(channelCallerId);
                    messagHandler.onMessage(channelCallerId);
                    break;
                case "ChannelUserevent":
                    ChannelUserevent channelUserevent = mapper.readValue(message, ChannelUserevent.class);
                    System.out.println(channelUserevent);
                    messagHandler.onMessage(channelUserevent);
                    break;
                case "ChannelHangupRequest":
                    ChannelHangupRequest channelHangupRequest = mapper.readValue(message, ChannelHangupRequest.class);
                    System.out.println(channelHangupRequest);
                    messagHandler.onMessage(channelHangupRequest);
                    break;
                case "ChannelVarset":
                    ChannelVarset channelVarset = mapper.readValue(message, ChannelVarset.class);
                    System.out.println(channelVarset);
                    messagHandler.onMessage(channelVarset);
                    break;
                case "ChannelTalkingStarted":
                    ChannelTalkingStarted channelTalkingStarted = mapper.readValue(message, ChannelTalkingStarted.class);
                    System.out.println(channelTalkingStarted);
                    messagHandler.onMessage(channelTalkingStarted);
                    break;
                case "ChannelTalkingFinished":
                    ChannelTalkingFinished channelTalkingFinished = mapper.readValue(message, ChannelTalkingFinished.class);
                    System.out.println(channelTalkingFinished);
                    messagHandler.onMessage(channelTalkingFinished);
                    break;
                case "ChannelHold":
                    ChannelHold channelHold = mapper.readValue(message, ChannelHold.class);
                    System.out.println(channelHold);
                    messagHandler.onMessage(channelHold);
                    break;
                case "ChannelUnhold":
                    ChannelUnhold channelUnhold = mapper.readValue(message, ChannelUnhold.class);
                    System.out.println(channelUnhold);
                    messagHandler.onMessage(channelUnhold);
                    break;
                case "ContactStatusChange":
                    ContactStatusChange contactStatusChange = mapper.readValue(message, ContactStatusChange.class);
                    System.out.println(contactStatusChange);
                    messagHandler.onMessage(contactStatusChange);
                    break;
                case "EndpointStateChange":
                    EndpointStateChange endpointStateChange = mapper.readValue(message, EndpointStateChange.class);
                    System.out.println(endpointStateChange);
                    messagHandler.onMessage(endpointStateChange);
                    break;
                case "Dial":
                    Dial dial = mapper.readValue(message, Dial.class);
                    System.out.println(dial);
                    messagHandler.onMessage(dial);
                    break;
                case "StasisEnd":
                    StasisEnd stasisEnd = mapper.readValue(message, StasisEnd.class);
                    System.out.println(stasisEnd);
                    messagHandler.onMessage(stasisEnd);
                    break;
                case "TextMessageReceived":
                    TextMessageReceived textMessageReceived = mapper.readValue(message, TextMessageReceived.class);
                    System.out.println(textMessageReceived);
                    messagHandler.onMessage(textMessageReceived);
                    break;
                case "ChannelConnectedLine":
                    ChannelConnectedLine channelConnectedLine = mapper.readValue(message, ChannelConnectedLine.class);
                    System.out.println(channelConnectedLine);
                    messagHandler.onMessage(channelConnectedLine);
                    break;
                case "PeerStatusChange":
                    PeerStatusChange peerStatusChange = mapper.readValue(message, PeerStatusChange.class);
                    System.out.println(peerStatusChange);
                    messagHandler.onMessage(peerStatusChange);
                    break;

                default:
                    System.out.println(jsonNode.toPrettyString());
            }


            session.getBasicRemote().sendText(message);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @OnError
    public void onError(Session session, Throwable throwable) {
        System.out.println("WebSocket error for " + session.getId() + " " + throwable.getMessage());
    }

    @OnClose
    public void onClose(Session session, CloseReason closeReason) {
        System.out.println("WebSocket closed for " + session.getId()
                + " with reason " + closeReason.getCloseCode());
        sessions.remove(session);
    }


}
