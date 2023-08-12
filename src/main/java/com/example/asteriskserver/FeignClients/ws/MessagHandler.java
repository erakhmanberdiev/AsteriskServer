package com.example.asteriskserver.FeignClients.ws;

import com.example.asteriskserver.FeignClients.AsteriskARI.Response.*;
import org.springframework.stereotype.Service;

/**
 * created by  :  erakhmanberdiev
 * created date & time: 12.08.2023  20:08
 */


public interface MessagHandler {
    void onMessage(PeerStatusChange peerStatusChange);

    void onMessage(StasisStart stasisStart);

    void onMessage(DeviceStateChanged deviceStateChanged);

    void onMessage(PlaybackStarted playbackStarted);

    void onMessage(PlaybackContinuing playbackContinuing);

    void onMessage(PlaybackFinished playbackFinished);

    void onMessage(RecordingStarted recordingStarted);

    void onMessage(RecordingFinished recordingFinished);

    void onMessage(RecordingFailed recordingFailed);

    void onMessage(ApplicationMoveFailed applicationMoveFailed);

    void onMessage(ApplicationReplaced applicationReplaced);

    void onMessage(BridgeCreated bridgeCreated);

    void onMessage(BridgeDestroyed bridgeDestroyed);

    void onMessage(BridgeMerged bridgeMerged);

    void onMessage(BridgeBlindTransfer bridgeBlindTransfer);

    void onMessage(BridgeAttendedTransfer bridgeAttendedTransfer);

    void onMessage(BridgeVideoSourceChanged bridgeVideoSourceChanged);

    void onMessage(ChannelCreated channelCreated);

    void onMessage(ChannelDestroyed channelDestroyed);

    void onMessage(ChannelEnteredBridge channelEnteredBridge);

    void onMessage(ChannelLeftBridge channelLeftBridge);

    void onMessage(ChannelStateChange channelStateChange);

    void onMessage(ChannelDtmfReceived channelDtmfReceived);

    void onMessage(ChannelDialplan channelDialplan);

    void onMessage(ChannelCallerId channelCallerId);

    void onMessage(ChannelUserevent channelUserevent);

    void onMessage(ChannelHangupRequest channelHangupRequest);

    void onMessage(ChannelVarset channelVarset);

    void onMessage(ChannelTalkingStarted channelTalkingStarted);

    void onMessage(ChannelTalkingFinished channelTalkingFinished);

    void onMessage(ChannelHold channelHold);

    void onMessage(ChannelUnhold channelUnhold);

    void onMessage(ContactStatusChange contactStatusChange);

    void onMessage(EndpointStateChange endpointStateChange);

    void onMessage(Dial dial);

    void onMessage(StasisEnd stasisEnd);

    void onMessage(TextMessageReceived textMessageReceived);

    void onMessage(ChannelConnectedLine channelConnectedLine);
}
