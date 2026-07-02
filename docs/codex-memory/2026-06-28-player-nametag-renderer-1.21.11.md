# 2026-06-28 Player nametag renderer on 1.21.11

## 状況

Minecraft 1.21.11 では `PlayerEntityRenderer` が `renderLabelIfPresent(PlayerEntityRenderState, ...)` を override している。
`EntityRenderer#renderLabelIfPresent(EntityRenderState, ...)` だけに mixin しても、サーバー上のプレイヤー名札は消えない。

## 学び

- プレイヤー名札を消す場合は `PlayerEntityRenderer` 側の描画メソッドも確認する。
- `PlayerEntityRenderState` には `id` があり、camera entity の `getId()` と比較できる。
- 自分の画面だけで名札を消す用途はクライアント mixin で対処できる。

## 次回の行動

- Minecraft バージョン更新時は `EntityRenderer`、`LivingEntityRenderer`、`PlayerEntityRenderer` の `renderLabelIfPresent` と `hasLabel` を `javap` などで確認する。
- プレイヤー専用 override がある場合は client mixin 設定に専用 mixin を登録する。
